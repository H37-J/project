import React from 'react';
import ReactDOM from 'react-dom';
import { createRoot } from 'react-dom/client';
import './_h/assets/sass/style.scss';

import {QueryClientProvider, QueryClient}  from 'react-query';
import AppReportTable from './app/pages/admin/report/AppReportTable';


const container = document.getElementById('root') 
const root = createRoot(container); 
const queryClient = new QueryClient()

root.render(
    <QueryClientProvider client={queryClient}>
       <AppReportTable />
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
