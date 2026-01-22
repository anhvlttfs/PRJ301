/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


'use strict';

const url = `http://localhost:8080/cp/artist`;

function PostDeleteUser(id, name) {
    let data = new URLSearchParams();
    data.append('action', 'delete');
    data.append(`inputId`, id);
    data.append(`inputName`, name);

    const options = {
      method: `POST`,
      body: data
    };

    fetch(url, options);
    window.location.href = window.location.origin + window.location.pathname
}