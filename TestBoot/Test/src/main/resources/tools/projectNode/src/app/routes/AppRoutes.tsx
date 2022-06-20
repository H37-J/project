import { FC, lazy } from 'react';
import { Routes, Route, BrowserRouter } from 'react-router-dom';
import { App } from '../App';

const AppRoutes = () => {
  const AppProfile = lazy(() => import('../pages/profile/AppProfile'))
  const AppDashBoard = lazy(() => import('../pages/dashboard/AppDashBoard'))
  return (
    <BrowserRouter basename="/">
      <Routes>
        <Route element={<App />}>
          <Route path="/DashBoard" element={<AppDashBoard />} />
          <Route path="/Profile" element={<AppProfile />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export { AppRoutes };
