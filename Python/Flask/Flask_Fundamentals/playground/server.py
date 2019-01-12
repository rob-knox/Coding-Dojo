from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play')
def index():
    return render_template("index.html", num=int(3))

@app.route('/play/<x>')
def multiple(x):
    return render_template("index.html", num=int(x))

@app.route('/play/<x>/<color>')
def changeColor(x, color):
    return render_template("index.html", num=int(x), color=color)

if __name__ == "__main__":
    app.run(debug=True)