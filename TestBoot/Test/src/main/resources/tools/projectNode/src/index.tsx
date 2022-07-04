import React from 'react';
import ReactDOM from 'react-dom';
import { createRoot } from 'react-dom/client';
import './_h/assets/sass/style.scss';

import {QueryClientProvider, QueryClient}  from 'react-query';
import { AppRoutes } from './app/routes/AppRoutes';

const container = document.getElementById('root') as HTMLElement
const root = createRoot(container); 
const queryClient = new QueryClient()

root.render(
    <QueryClientProvider client={queryClient}>
       <AppRoutes />
    </QueryClientProvider>,
);

// setupAxios(axios);
// const store = createStore(RootReducer, composeWithDevTools());

// ReactDOM.render(
//   <QueryClientProvider client={queryClient}>
//     <MetronicI18nProvider>
//       <AuthProvider>
//         <AppRoutes />
//       </AuthProvider>
//     </MetronicI18nProvider>
//     <ReactQueryDevtools initialIsOpen={false} />
//   </QueryClientProvider>,
//   document.getElementById('root'),
// );
