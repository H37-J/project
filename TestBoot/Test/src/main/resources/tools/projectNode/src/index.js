import React from 'react';
import ReactDOM from 'react-dom/client';
import { createStore } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';
import RootReducer from './app/reducers/modules/RootReducer';
import axios from 'axios';

import './_h/assets/sass/style.scss';
import { ProjectTable } from './project/components/table/ProejctTable';
import Clock from './app/components/clock/Clock';
import { CourseTable } from './project/components/table/CourseTable';


const container = document.getElementById('root');

ReactDOM.createRoot(container).render(
    <CourseTable />
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
