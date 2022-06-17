import { FC } from 'react';
import { Routes, Route, BrowserRouter, Navigate } from 'react-router-dom';
import { Login } from '../auth/components/Login';
import { useAuth } from '../auth/core/Auth';
import { App } from '../../App';

const AppRoutes: FC = () => {
  const { currentUser } = useAuth();
  
  return (
    <BrowserRouter basename="/">
      <Routes>
        <Route element={<App />}>
            <Route path="/auth" element={<Login />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
};

export { AppRoutes };
