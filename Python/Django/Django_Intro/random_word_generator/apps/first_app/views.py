from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def index(request):
    request.session['rand'] = get_random_string(length=14)
    if 'count' in request.session:
        request.session['count'] = request.session['count'] + 1
    else:
        request.session['count'] = 1
    return render(request, 'rwg/index.html')

def reset(request):
    return redirect('/random_word')