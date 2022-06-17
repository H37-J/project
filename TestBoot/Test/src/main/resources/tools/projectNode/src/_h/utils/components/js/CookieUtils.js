export class CookieUtils {
    static get(name) {
        const matches = document.cookie.match(
            new RegExp(
                '(?:^|; )' +
                name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') +
                '=([^;]*)',
            ),
        );
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    static set(name, value, cookieOptions) {
        const options = {
            path: '/',
            ...cookieOptions
        }
        if (options.expires instanceof Date) {
            options.expires = options.expires.toUTCString()
        }

        let updateCookie = encodeURI(name) + '=' + encodeURIComponent(value)

        for (let optionKey in options) {
            updateCookie += ';' + optionKey
            let optionValue = options[optionKey]
            if (optionValue !== true) {
                updateCookie += '=' + optionValue
            }
        }
        document.cookie = updateCookie
    }

    static delete(name) {
        CookieUtils.set(name, '', {
            'max-age': -1
        })
    }
}