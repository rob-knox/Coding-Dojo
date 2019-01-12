from django.shortcuts import render, HttpResponse, redirect
# renders the index page
def index(request):
    if 'name' in request.session:
        request.session['count'] += 1
    else:
        request.session['count'] = 1
    
    return render(request, 'survey_form/index.html') 

# processes the form then redirects the form to the function below
def process(request):
    if request.method == "POST":
        request.session['name'] = request.POST['name']
        request.session['dojo'] = request.POST['dojo']
        request.session['language'] = request.POST['language']
        request.session['comments'] = request.POST['comments']
        print(request.POST) #prints to the terminal
        print(request.POST['name']) #prints the name to the terminal 
    return redirect('/result') 

# renders the results page
def result(request):
    return render(request, 'survey_form/result.html')
