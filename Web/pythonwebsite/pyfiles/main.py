# import function from the website package
from website import create_app
# creates flask app 
app = create_app()
# only runs the app if the file is executed directly
if __name__ == '__main__':
    app.run(debug=True) # starts the flask dev server
