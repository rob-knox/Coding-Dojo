from flask import Flask, render_template, request, redirect
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/result', methods=['POST'])
def addComment():
    name = request.form['name']
    dojo = request.form['dojo']
    language = request.form['language']
    comment = request.form['comment']
    url = '/'

    return render_template('result.html', name=name, dojo=dojo, language=language, comment=comment, url=url)

@app.route('/danger')
def errorMessage():
    print("a user tried to visit /danger.  We have redirected the user to '/'")
    return redirect('/')

if __name__=="__main__":
    app.run(debug=True)