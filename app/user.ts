import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Post } from './post';

export class User {
    firstname: string;
    lastname: string;
    email: string;
    password: string;
    description: string;
    profilePic: string;
    postList: Post[];

    public constructor() {
        this.firstname = '';
        this.lastname = '';
        this.email = '';
        this.password = '';
        this.description = '';
    }
}
