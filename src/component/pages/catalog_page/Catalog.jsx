import React from 'react';
import axios from "axios";
import { useState } from "react";


const Catalog = () => {
    let [list, setList] = useState([]);

    if(list.length === 0){
        axios.get("http://localhost:8080/getAll")
        .then((res) => {
            setList((list) => {
                return res.data.map((el) => {
                    return (
                        <li>
                            <h3>{el.id}</h3>
                            <h3>{el.login}</h3>
                            <h3>{el.password}</h3>
                            <h3>{el.email}</h3>
                            <div>
                                <p>Имя пользователя: {el.infoUser.name}</p>
                                <p>Фмилия пользователя: {el.infoUser.serName}</p>
                                <p>Отчество пользователя: {el.infoUser.patrol}</p>
                                <p>Возраст пользователя: {el.infoUser.age}</p>
                                <p>Телефон пользователя: {el.infoUser.phone}</p>
                            </div>
                        </li>
                    )
                })
            })
        }).catch(error =>{
            console.log(error)
        })
    }
    return (
        <div>
            <h1>Каталог</h1>
            <a href='/'> Домашняя страница </a>
            <br />
            <a href='/registry'> регистрация </a>
            <br />

            <ul>
                {list}
            </ul>
        </div>
    );
};

export default Catalog;