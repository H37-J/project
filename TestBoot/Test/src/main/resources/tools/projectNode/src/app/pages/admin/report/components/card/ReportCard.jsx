import React from "react";

import clsx from 'clsx'
const ReportCard = (props) => {
    const {
        className,
        shadow,
        flush,
        resetSidePaddings,
        border,
        dashed,
        stretch,
        rounded,
        utilityP,
        utilityPY,
        utilityPX,
        children,
    } = props
    return (
        <div
            className={clsx(
                'card',
                className && className,
                {
                    'shadow-sm': shadow,
                    'card-flush': flush,
                    'card-px-0': resetSidePaddings,
                    'card-bordered': border,
                    'card-dashed': dashed,
                },
                stretch && `card-${stretch}`,
                utilityP && `p-${utilityP}`,
                utilityPX && `px-${utilityPX}`,
                utilityPY && `py-${utilityPY}`,
                rounded && `card-${rounded}`
            )}
        >
            {children}
        </div>
    )
}

export default ReportCard
