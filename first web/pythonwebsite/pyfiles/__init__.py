# import framework and modules
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from os import path
from flask_login import LoginManager
# create and name database
db = SQLAlchemy()
DB_NAME = "database.db"
# creates and configures flask application
def create_app():
    app = Flask(__name__)
    app.config['SECRET_KEY'] = 'afy123'
    app.config['SQLALCHEMY_DATABASE_URI'] = f'sqlite:///{DB_NAME}'
    db.init_app(app)
    # import blueprints
    from .views import views
    from .auth import auth
    # register blueprints
    app.register_blueprint(views, url_prefix='/')
    app.register_blueprint(auth, url_prefix='/')
    # import models
    from .models import User, Note
    # create database if it doesn't exist
    create_database(app)
    # setup and initalize login manager and redirect users 
    login_manager = LoginManager()
    login_manager.login_view = 'auth.login'
    login_manager.init_app(app)
    # the user loader function
    @login_manager.user_loader
    def load_user(id):
        return User.query.get(int(id))

    return app

# function used to create database
def create_database(app):
    db_path = path.join(path.dirname(__file__), DB_NAME)
    # to check if database exists
    if not path.exists(db_path):
        with app.app_context():
            db.create_all()
        print("Created Database!")

