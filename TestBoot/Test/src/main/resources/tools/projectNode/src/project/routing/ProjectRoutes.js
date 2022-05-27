import { FC } from 'react';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import BasicButtons from '../components/button/buttonOne';
import { ProjectTable } from '../components/table/ProejctTable.js';

const ProjectRoutes = () => {
  return (
    <BrowserRouter basename="/">
      <Routes>
            <Route path="/" element={<BasicButtons/>} />
            <Route path="/table" element={<ProjectTable/>} />
      </Routes>
    </BrowserRouter>
  );
};

export { ProjectRoutes };
