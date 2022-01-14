from flask import Flask, jsonify, request
from flask_pymongo import PyMongo
from bson.json_util import dumps
from bson.objectid import ObjectId
import logging

app = Flask(__name__)
app.config["MONGO_URI"] = "mongodb+srv://ayonelahi:ayonelahi@cluster0.qnhj7.mongodb.net/BarberShop?retryWrites=true&w=majority"
mongo = PyMongo(app)


@app.route("/getAll")
def get_add():
    barbers = mongo.db.Barber.find()
    resp = dumps(barbers)
    return resp


@app.route("/getSingle/<id>")
def get_single(id):
    barber = mongo.db.Barber.find_one({'_id': ObjectId(id)})
    resp = dumps(barber)
    return resp

@app.route("/getSingleAppointment/<id>")
def get_single_appt(id):
    barber = mongo.db.Barber.find_one({'_id': ObjectId(id)},{"name":0,"email":0,"contact":0,"_id":0})
    print(barber, flush=True)
    resp = dumps(barber)
    return resp
    


@app.route("/delete/<id>", methods=["DELETE"])
def delete_single(id):
    barber = mongo.db.Barber.delete_one({'_id': ObjectId(id)})
    resp = jsonify("User deleted successfully")
    resp.status_code = 200
    return resp


@app.route("/update/<id>", methods=["PUT"])
def update_single(id):
    _id = id
    _json = request.json
    _name = _json['name']
    _email = _json['email']
    _contact = _json['contact']
    _appointment = _json['appointment']

  

    if _name and _email and _contact and request.method == 'PUT':
        id = mongo.db.Barber.update_one({'_id': ObjectId(_id['$oid']) if '$oid' in _id else ObjectId(
            _id)}, {'$set': {'name': _name, 'email': _email, 'contact': _contact, 'appointment':_appointment}})
        resp = jsonify("barber updated successfully")
        resp.status_code = 200
        return resp

@app.route("/patch/<id>", methods=["PATCH"])
def patch_single(id):
    _id = id
    _json = request.json
    # print(_json, flush=True)
    _appointment = _json['appointment']
    
  
  

    if request.method == 'PATCH' and _appointment:
        id = mongo.db.Barber.update_one({'_id': ObjectId(_id['$oid']) if '$oid' in _id else ObjectId(
            _id)}, {'$push': {'appointment':_appointment}})
        resp = jsonify("barber updated successfully")
        resp.status_code = 200
        return resp        


@app.route("/add", methods=['POST'])
def add_barber():
    _json = request.json
    # print(_json, flush=True)
    _name = _json['name']
    _email = _json['email']
    _contact = _json['contact']
    _appointment = []

    if _name and _email and _contact and request.method == 'POST':
        id = mongo.db.Barber.insert_one(
            {'name': _name, 'email': _email, 'contact': _contact , 'appointment': _appointment})
        resp = jsonify("barber added successfully")
        resp.status_code = 200
        return resp
        

if(__name__=="__main__"):
    app.run("0.0.0.0",debug="True")
