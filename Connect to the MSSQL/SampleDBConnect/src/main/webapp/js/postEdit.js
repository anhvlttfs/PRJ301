/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


'use strict';

const url = `http://localhost:8080/cp/artist`;

function PostEditUser(id) {
    let data = new URLSearchParams();
    const inputNewName = document.getElementById("inputName");
    const inputNameValue = inputNewName.value;
    
    console.log("Id is " + id);
    
    data.append('action', 'edit');
    data.append(`inputId`, id);
    data.append(`inputNewName`, inputNameValue);

    const options = {
      method: `POST`,
      body: data
    };
    
    fetch(url, options);
    window.location.href = window.location.origin + window.location.pathname
}