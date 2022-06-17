import {useEffect} from 'react'
import {CPUChartInit, DiskChartInit, LoadChartInit, MeomoryChartInit, } from '../../../../_h/assets/ts/chart/charts'

const HardWareInfo = () => {
  useEffect(() => {
    CPUChartInit()
    MeomoryChartInit()
    DiskChartInit()
    LoadChartInit()
  }, [])
  return (
    <div className='row gy-5 g-xl-8'>
      <div className='col-md-6 col-lg-6 col-xl-6 col-xxl-3 mt-min-sm-9 mt-min-md-9 mt-min-l-9 mb-md-5 mb-xl-10'>
        <div className='card card-flush'>
          <div className='card-header pt-5'>
            <div className='card-title'>
              <span className='fs-2qx fw-bolder text-dark me-2 lh-1 ls-n2'>CPU</span>
            </div>
          </div>
          <div className='card-body pt-2 pb-4 d-flex align-items-center'>
            <div className='d-flex flex-center me-5 pt-2'>
              <div id='cpu-chart' data-h-size='70' data-h-line='11'></div>
            </div>
            <div className='d-flex flex-column content-justify-center w-100'>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 bg-success me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Total</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center my-3'>
                <div className='bullet w-8px h-3px rounded-2 bg-primary me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Used</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>65%</div>
              </div>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Free</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>35%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className='col-md-6 col-lg-6 col-xl-6 col-xxl-3 mt-min-l-9 mb-md-5 mb-xl-10'>
        <div className='card card-flush'>
          <div className='card-header pt-5'>
            <div className='card-title'>
              <span className='fs-2qx fw-bolder text-dark me-2 lh-1 ls-n2'>MEMORY</span>
            </div>
          </div>
          <div className='card-body pt-2 pb-4 d-flex align-items-center'>
            <div className='d-flex flex-center me-5 pt-2'>
              <div id='memory-chart' data-h-size='70' data-h-line='11'></div>
            </div>
            <div className='d-flex flex-column content-justify-center w-100'>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 bg-success me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Total</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center my-3'>
                <div className='bullet w-8px h-3px rounded-2 bg-primary me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Used</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>65%</div>
              </div>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Free</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>35%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className='col-md-6 col-lg-6 col-xl-6 col-xxl-3 mb-md-5 mb-xl-10'>
        <div className='card card-flush'>
          <div className='card-header pt-5'>
            <div className='card-title'>
              <span className='fs-2qx fw-bolder text-dark me-2 lh-1 ls-n2'>DISK </span>
            </div>
          </div>
          <div className='card-body pt-2 pb-4 d-flex align-items-center'>
            <div className='d-flex flex-center me-5 pt-2'>
              <div id='disk-chart' data-h-size='70' data-h-line='11'></div>
            </div>
            <div className='d-flex flex-column content-justify-center w-100'>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 bg-success me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Total</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center my-3'>
                <div className='bullet w-8px h-3px rounded-2 bg-primary me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Used</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Free</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>0%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div className='col-md-6 col-lg-6 col-xl-6 col-xxl-3 mb-md-5 mb-xl-10 mb-min-sm-8'>
        <div className='card card-flush'>
          <div className='card-header pt-5'>
            <div className='card-title'>
              <span className='fs-2qx fw-bolder text-dark me-2 lh-1 ls-n2'>LOAD</span>
            </div>
          </div>
          <div className='card-body pt-2 pb-4 d-flex align-items-center'>
            <div className='d-flex flex-center me-5 pt-2'>
              <div id='load-chart' data-h-size='70' data-h-line='11'></div>
            </div>
            <div className='d-flex flex-column content-justify-center w-100'>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 bg-success me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Total</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>$100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center my-3'>
                <div className='bullet w-8px h-3px rounded-2 bg-primary me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Used</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>100%</div>
              </div>
              <div className='d-flex fw-bold align-items-center'>
                <div className='bullet w-8px h-3px rounded-2 me-3'></div>
                <div className='text-gray-500 flex-grow-1 me-4'>Free</div>
                <div className='fw-boldest text-gray-700 text-xxl-end'>0%</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export {HardWareInfo}
