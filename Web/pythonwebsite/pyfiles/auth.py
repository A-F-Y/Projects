# import modules, blueprints, templates, and function utilities 
from flask import Blueprint, render_template, request, flash, redirect, url_for
from .models import User
from werkzeug.security import generate_password_hash, check_password_hash   
from . import db
from flask_login import login_user, login_required, logout_user, current_user
# creates auth blueprint
auth = Blueprint('auth', __name__)
# the login route
@auth.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        email = request.form.get('email')
        password = request.form.get('password')
        # finds the user's email 
        user = User.query.filter_by(email=email).first()
        if user:
            # check user password and logs user in 
            if check_password_hash(user.password, password):
               flash('Logged in successfully!', category='success')
               login_user(user, remember=True)
                # redirects to the home page
                return redirect(url_for('views.home'))
            else:
                flash('Incorrect password, try again.', category='error')
        else:
            flash('Email does not exist.', category='error')
    # renders the login page
    return render_template("login.html", user=current_user)
# the logout route
@auth.route('/logout')
@login_required # user has to be logged in to access route
def logout(): # logout the user
    logout_user()
    return redirect(url_for('auth.login')) # redirect to the login page
# the sign-up route
@auth.route('/sign-up', methods=['GET', 'POST'])
def sign_up(): # check if the form is in and gets the form's data
    if request.method == 'POST':
        email = request.form.get('email')
        first_name = request.form.get('firstName')
        password1 = request.form.get('password1')
        password2 = request.form.get('password2')
        # checks if user exist already 
        user = User.query.filter_by(email=email).first()
        # various validation check
        if user:
            flash('Email already exists.', category='error')
        elif len(email) < 4:
            flash('Email must be greater than 3 characters.', category='error')
        elif len(first_name) < 2:
             flash('First name must be greater than 1 characters.', category='error')
        elif password1 != password2:
             flash('Password don\'t match.', category='error')
        elif len(password1) < 7:
             flash('Password must be at least 7 characters.', category='error')
        else:
            # creates new user with a hashed password
            new_user = User(email=email, first_name=first_name, password=generate_password_hash(password1, method='pbkdf2:sha256'))
            db.session.add(new_user) # adds new user to database
            db.session.commit()
            login_user(user, remember=True)
            # logs in and successfully added new user to the database
            flash('Account created!', category='success')
            return redirect(url_for('views.home'))
    # renders the sign-up page    
    return render_template("signup.html", user=current_user)

