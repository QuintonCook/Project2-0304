import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

export class User{
    firstname:String;
    lastname:String;
    email:String;
    password:String;
    description:String;
    profilePic:String;

    public constructor(){
        this.firstname="";
        this.lastname="";
        this.email="";
        this.password="";
        this.description="";
    }
}