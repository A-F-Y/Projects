# imports database, usermixin, function
from . import db
from flask_login import UserMixin
from sqlalchemy.sql import func
# the note model for notes created by users 
class Note(db.Model):
    id = db.Column(db.Integer, primary_key=True) # id for each note created
    data = db.Column(db.String(10000)) # notes can have up to 10,000 characters 
    date = db.Column(db.DateTime(timezone=True), default=func.now()) # date and time note was made
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))

# the user model for registered users
class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True) # user id
    email = db.Column(db.String(150), unique=True) # user email
    password = db.Column(db.String(150)) # user hashed password
    first_name = db.Column(db.String(150)) # user's first name
    # Add more fields if necessary
    notes = db.relationship('Note')
    # a relationship to the Note class model



