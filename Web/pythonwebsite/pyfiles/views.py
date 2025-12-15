# import blueprint, flash, render template, request, login, models, modules, database and jsonify 
from flask import Blueprint, flash, render_template, request, jsonify
from flask_login import login_required, current_user
from .models import Note
from . import db
import json
# creates the views blueprint
views = Blueprint('views', __name__)
# the home route
@views.route('/', methods=['GET', 'POST'])
@login_required
def home():
    if request.method == 'POST': # note submissions
        note = request.form.get('note') # gets the note content
        # note length
        if len(note) < 1:
            flash('Note is too short!', category='error')
        else:
            new_note = Note(data=note, user_id=current_user.id) # new note links to the user
            db.session.add(new_note) # note is added to database
            db.session.commit()
            flash('Note added!', category='success')
    # renders the home page to the user 
    return render_template("home.html", user=current_user)
# the delete note route 
@views.route('/delete-note', methods=['POST'])
@login_required # only users logged in can delete notes
def delete_note():
    note = json.loads(request.data) # json data is sent from the frontend
    noteId = note['noteId']
    note = Note.query.get(noteId) # finds note by the id
    if note: # checks if the note still exists within the current user
        if note.user_id == current_user.id:
            db.session.delete(note) # deletes not from the database
            db.session.commit()
    
    # returns an empty json response
    return jsonify({})
