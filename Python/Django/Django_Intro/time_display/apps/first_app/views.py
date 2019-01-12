from django.shortcuts import render, HttpResponse, redirect
from time import gmtime, strftime

def index(request):
    response = "Hello, I am your first request!"
    return HttpResponse(response)

def time_display(request):
    context = {
        'date': strftime("%b %d, %Y %I:%M %p", gmtime())
    }
    return render(request,'time_display/index.html', context)