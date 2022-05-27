import { Suspense, useEffect } from 'react';
import { Outlet } from 'react-router-dom';
import { LayoutSplashScreen } from '../_h/layout/core/HSplashScreen';
import { LayoutProvider } from '../_h/layout/core/LayoutProvider';
import { HInit } from '../_h/layout/HInit';
import { AuthInit } from './modules/auth';


const App = () => {
  return (
    <Suspense fallback={<LayoutSplashScreen />}>
        <LayoutProvider>
          <AuthInit>
            <Outlet />
            <HInit />
          </AuthInit>
        </LayoutProvider>
    </Suspense>
  );
};

export { App };
