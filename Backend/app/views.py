from django.shortcuts import render

# Create your views here.
from django.http import JsonResponse, HttpResponse
from django.db import connection
from django.views.decorators.csrf import csrf_exempt
import json
import os, time
from django.conf import settings
from django.core.files.storage import FileSystemStorage

@csrf_exempt
def postcomments(request):
    if request.method != 'POST':
        return HttpResponse(status=400)

    # loading form-encoded data
    username = request.POST.get("username")
    message = request.POST.get("message")
    star = request.POST.get("star")
        
    cursor = connection.cursor()
    cursor.execute('INSERT INTO comments (username, message, star) VALUES '
                   '(%s, %s, %s);', (username, message, star))

    return JsonResponse({})

def getcomments(request):
    if request.method != 'GET':
        return HttpResponse(status=404)
    

    cursor = connection.cursor()
    cursor.execute('SELECT * FROM comments ORDER BY time DESC;')
    rows = cursor.fetchall()

    response = {}
    response['comments'] = rows
    return JsonResponse(response)

@csrf_exempt
def setcart(request):
    if request.method != 'POST':
        return HttpResponse(status=400)

    # loading form-encoded data
    username = request.POST.get("username")
    productid = request.POST.get("productid")
    number = request.POST.get("number")
        
    cursor = connection.cursor()
    # postgresql change entry number to number from table cart that has username=username and productid=productid
    cursor.execute('UPDATE cart SET number=%s WHERE username=%s AND productid=%s;', (number, username, productid))

    return JsonResponse({})

def getcart(request):
    if request.method != 'GET':
        return HttpResponse(status=404)
    
    username = request.POST.get("username")

    cursor = connection.cursor()
    # posegresql get all rows from table cart that has username=username
    cursor.execute('SELECT * FROM cart WHERE username=%s;', (username,))
    rows = cursor.fetchall()

    response = {}
    response['comments'] = rows
    return JsonResponse(response)

@csrf_exempt
def rmcart(request):
    if request.method != 'POST':
        return HttpResponse(status=400)

    # loading form-encoded data
    username = request.POST.get("username")
    productid = request.POST.get("productid")
        
    cursor = connection.cursor()
    # postgresql remove rows from table cart that has username=username and productid=productid
    cursor.execute('DELETE FROM cart WHERE username=%s AND productid=%s;', (username, productid))

    return JsonResponse({})
