import React from 'react';
import Registry from '../registry/registry';

const HomePage = () => {
    return (
        <div>
            <h1>Домашняя страница</h1>
            <a href='/catalog'> Каталог </a>
            <br />
            <a href='/registry'> регистрация</a>
        </div>
    );
};

export default HomePage;