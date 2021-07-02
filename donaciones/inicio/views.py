from django.shortcuts import render
from django.http import HttpResponse

# Create your views here.
def myHomeView(request, *args, **kwargs):
	return render(request,"home.html",{})

def pastelView(request, *args, **kwargs):
	return render(request,"graphics/pastel.html",{})

def areaView(request, *args, **kwargs):
	return render(request,"graphics/region.html",{})

def tableView(request, *args, **kwargs):
	return render(request,"graphics/table.html",{})