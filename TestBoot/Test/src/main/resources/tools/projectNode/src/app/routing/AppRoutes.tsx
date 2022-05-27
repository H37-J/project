import { FC } from 'react';
import { Routes, Route, BrowserRouter, Navigate } from 'react-router-dom';
import { Content } from '../components/Content';
import { Login } from '../modules/auth/components/Login';
import { useAuth } from '../modules/auth/core/Auth';
import { App } from '../App';

const AppRoutes: FC = () => {
  const { currentUser } = useAuth();
  
  return (
    <BrowserRouter basename="/">
      <Routes>
        <Route element={<App />}>
            <Route path="/*" element={<Content />} />
            <Route path="/auth" element={<Login />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export { AppRoutes };
