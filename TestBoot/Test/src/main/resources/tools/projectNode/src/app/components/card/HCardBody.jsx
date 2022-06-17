import clsx from 'clsx'

const HCardBody = (props) => {
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

export { HCardBody }
