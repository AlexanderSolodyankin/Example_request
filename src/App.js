// import logo from './logo.svg';
import './App.css';

import { BrowserRouter, Routes, Route } from "react-router-dom";

import HomePage from './component/pages/home_page/HomePage';
import Catalog from './component/pages/catalog_page/Catalog';
import Registry from './component/pages/registry/registry';

function App() {
  return (
    <div className="App">
      <header className="App-header">

      <BrowserRouter>
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/catalog" element={<Catalog />} />
            <Route path="/registry" element={<Registry/>}/>
          </Routes>
        </BrowserRouter>
       
      </header>
    </div>
  );
}

export default App;
