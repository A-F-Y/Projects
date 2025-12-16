# import flask class, utilities, and SQLAlchemy for database 
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from flask_restful import Resource, Api, reqparse, fields, marshal_with, abort

app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///database.db' # configures SQL database
db = SQLAlchemy(app) # initializes database
api = Api(app) # initializes the REST API

# the database model
class UserModel(db.Model):
    id = db.Column(db.Integer, primary_key=True) # user id
    name = db.Column(db.String(80), unique=True, nullable=False) # user name
    email = db.Column(db.String(80), unique=True, nullable=False) # user email
    # object representation for debugging 
    def __repr__(self):
        return f"User(name = {self.name}, email = {self.name})"

# requests Parser and adds a required name and email field for user
user_args = reqparse.RequestParser()
user_args.add_argument('name', type=str, required=True, help="Name cannot be blank")
user_args.add_argument('email', type=str, required=True, help="Email cannot be blank")
# controls the API output
userFields = {
    'id':fields.Integer,
    'name':fields.String,
    'email':fields.String,
}
# the API resource 
class Users(Resource):
    # GET all the users
    @marshal_with(userFields)
    def get(self):
        users = UserModel.query.all()
        return users
    # POST a new user 
    @marshal_with(userFields)
    def post(self):
        args = user_args.parse_args()
        user = UserModel(name=args["name"], email=args["email"]) # creates a new user
        db.session.add(user)
        db.session.commit() # saves the new data into the database
        users = UserModel.query.all()
        return users, 201 # returns all users the 201 status
    
class User():
    # GET a user by their id
    @marshal_with(userFields)
    def get(self, id):
        user = UserModel.query.filter_by(id=id).first()
        if not user:
            abort(404, "User not found")
            return user 
    # PATCH a user      
    @marshal_with(userFields)
    def patch(self, id):
        args = user_args.parse_args()
        user = UserModel.query.filter_by(id=id).first()
        if not user:
            abort(404, "User not found")
            user.name = args["name"] # update name
            user.email = args["email"] # update email
            db.session.commit()
            return user 
    # deletes a user
    @marshal_with(userFields)
    def delete(self, id):
        user = UserModel.query.filter_by(id=id).first()
        if not user:
            abort(404, "User not found")
            db.session.delete(user)
            db.session.commit()
            users = UserModel.query.all() # returns the users left
            return users #could add 204 here
# the API routes
api.add_resource(Users, '/api/users/')
api.add_resource(User, '/api/users/<int:id>')

# home route
@app.route('/')
def home():
    return '<h1>Flask REST API</h1>'
# runs the application
if __name__ == '__main__':
    app.run(debug=True)


