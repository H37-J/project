import React from "react";
import clsx from 'clsx'
const ReportCardBody = (props) => {
    const { className, scroll, height, children } = props
    return (
        <div
            className={clsx(
                'card-body',
                className && className,
                {
                    'card-scroll': scroll,
                },
                height && `h-${height}px`
            )}
        >
            {children}
        </div>
    )
}

export default ReportCardBody 
