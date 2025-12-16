# import flask, app, and db to create the database
from flaskrestapi import app, db
with app.app_context():

    db.create_all()
