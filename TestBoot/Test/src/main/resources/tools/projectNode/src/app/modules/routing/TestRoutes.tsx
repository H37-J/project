import { FC } from 'react';
import { Routes, Route, BrowserRouter, Navigate } from 'react-router-dom';



const TestRoutes: FC = () => {
  return (
    <BrowserRouter basename="/">
      <Routes>

      </Routes>
    </BrowserRouter>
  );
};

export { TestRoutes };
