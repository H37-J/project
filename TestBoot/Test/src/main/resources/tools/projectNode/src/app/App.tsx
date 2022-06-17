
import { AppToolBar } from './components/toolbar/AppToolBar';
import { AppContent } from './template/AppContent';
import { AppHeader } from './template/header/AppHeader';
import { AppSide } from './template/side/AppSide';


const App = () => {
  return (
    <div className="flex flex-row flex-column-fluid">
      <AppSide />
      <div className="wrapper flex flex-col flex-row-fluid">
        <AppHeader />
        <AppToolBar />
        <AppContent />
      </div>
    </div>
  );
};

export { App };
