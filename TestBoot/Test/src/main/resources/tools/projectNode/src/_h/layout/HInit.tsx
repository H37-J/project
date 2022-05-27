import { useEffect, useRef } from 'react';
import { useLayout } from './core/LayoutProvider';

export function HInit() {
  const { config } = useLayout();
  const isFirstRun = useRef(true);
  const Initialization = () => {
    isFirstRun.current = false;
  };

  useEffect(() => {
    if (isFirstRun.current) {
      isFirstRun.current = false;
      Initialization();
    }
  }, [config]);
  return <></>;
}
