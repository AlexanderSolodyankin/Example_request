import React from "react";
import axios from "axios";
import { Formik, Field, Form } from 'formik';

const Registry = () => {
  
  const sendRequest = (data) => {
    axios({
      method: "post",
      url: "http://localhost:8080/newUser",
      data: {
        login: data.login,
        password: data.password,
        email: data.email,
        infoUser: {
          name: data.name,
          serName: data.sername,
          patrol: data.patrol,
          age: data.age,
          phone: data.phone,
        },
      },
    }).then((res) => {
      console.log(res);
    });
  };  

  return (
    <div>
      <h1>Регистрация</h1>
      <a href="/">Домашняя страница</a>
      <br />
      <a href="/catalog">Каталог</a>
      <div>

      <Formik
      initialValues={{
         login: '',
         password: '',
         email: '',
         name: '',
         serName: '',
         patrol: '',
         age: '',
         phone: ''
      }}
      onSubmit={async (values) => {
        await new Promise((r) => setTimeout(r, 500));
        alert(JSON.stringify(values, null, 2)); // нужен для того чтобы отслеживать что отправилось
        sendRequest(values)
      }}
    >
      <Form>
        <label htmlFor="login">Введите логин</label>
        <Field id="login" name="login" placeholder="Введите логин" />
        <br />

        <label htmlFor="password">Введите пароль</label>
        <Field id="password" name="password" placeholder="Введите пароль" type="password" />
        <br/>

        <label htmlFor="email">Email</label>
        <Field
          id="email"
          name="email"
          placeholder="jane@acme.com"
          type="email"
        />
        <br/>
        
        <label htmlFor="name">Введите имя</label>
        <Field id="name" name="name" placeholder="Введите имя" />
        <br />
        
        <label htmlFor="serName">Введите фамилию</label>
        <Field id="serName" name="serName" placeholder="Введите фамилию" />
        <br />
        
        <label htmlFor="patrol">Введите отчество</label>
        <Field id="patrol" name="patrol" placeholder="Введите отчество" />
        <br />
        
        <label htmlFor="age">Введите возраст</label>
        <Field id="age" name="age" placeholder="Введите возраст" type="number" />
        <br />
        
        <label htmlFor="phone">Введите номер телефона</label>
        <Field id="phone" name="phone" placeholder="Введите номер телефона" />
        <br />
        <button type="submit">Submit</button>
      </Form>
    </Formik>
      </div>
    </div>
  );
};

export default Registry;



