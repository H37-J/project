function alertCartSave(){
    const title = '알림',
            msg = '상품을 장바구니에 추가 하였습니다',

            type = 'success',
            layout = 'topCenter',
            theme = 'unify--v1',

            isCloseButton = true,
            isProgressBar = true,
            timeOut = '1000'

             animationIn = 'fadeIn',
            animationOut = 'fadeOut',

            markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
            resultMarkup = function () {
                if (title != '' && msg != '') {
                    return markup;
                } else {
                    return markupDef;
                }
            };

        opts = {
            type: type,
            layout: layout,
            timeout: isProgressBar == true ? timeOut : false,
            animation: {
                open: 'animated ' + animationIn,
                close: 'animated ' + animationOut
            },
            closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
            text: resultMarkup(),
            theme: theme != '' ? theme : 'unify--v1'
        };

        var newNoty = new Noty(opts).show();

        $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');

}

function alertCartDelete(){
    const title = '알림',
            msg = '상품을 장바구니에서 삭제 하였습니다',

            type = 'success',
            layout = 'topCenter',
            theme = 'unify--v1',

            isCloseButton = true,
            isProgressBar = true,
            timeOut = '1000'

             animationIn = 'fadeIn',
            animationOut = 'fadeOut',

            markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
            resultMarkup = function () {
                if (title != '' && msg != '') {
                    return markup;
                } else {
                    return markupDef;
                }
            };

        opts = {
            type: type,
            layout: layout,
            timeout: isProgressBar == true ? timeOut : false,
            animation: {
                open: 'animated ' + animationIn,
                close: 'animated ' + animationOut
            },
            closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
            text: resultMarkup(),
            theme: theme != '' ? theme : 'unify--v1'
        };

        var newNoty = new Noty(opts).show();

        $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');
}

function alertProductDelete(){
      const title = '알림',
            msg = '상품을 제거 하였습니다',

            type = 'success',
            layout = 'topCenter',
            theme = 'unify--v1',

            isCloseButton = true,
            isProgressBar = true,
            timeOut = '1000'

             animationIn = 'fadeIn',
            animationOut = 'fadeOut',

            markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
            resultMarkup = function () {
                if (title != '' && msg != '') {
                    return markup;
                } else {
                    return markupDef;
                }
            };

        opts = {
            type: type,
            layout: layout,
            timeout: isProgressBar == true ? timeOut : false,
            animation: {
                open: 'animated ' + animationIn,
                close: 'animated ' + animationOut
            },
            closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
            text: resultMarkup(),
            theme: theme != '' ? theme : 'unify--v1'
        };

        var newNoty = new Noty(opts).show();

        $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');
}

function alertSetAddress(){
    const title = '알림',
          msg = '기본 주소를 변경 하였습니다',

          type = 'success',
          layout = 'topCenter',
          theme = 'unify--v1',

          isCloseButton = true,
          isProgressBar = true,
          timeOut = '1000'

           animationIn = 'fadeIn',
          animationOut = 'fadeOut',

          markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
          resultMarkup = function () {
              if (title != '' && msg != '') {
                  return markup;
              } else {
                  return markupDef;
              }
          };

      opts = {
          type: type,
          layout: layout,
          timeout: isProgressBar == true ? timeOut : false,
          animation: {
              open: 'animated ' + animationIn,
              close: 'animated ' + animationOut
          },
          closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
          text: resultMarkup(),
          theme: theme != '' ? theme : 'unify--v1'
      };

      var newNoty = new Noty(opts).show();

      $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');

}

function alertOrderCancel(){
    const title = '알림',
        msg = '주문을 취소 하였습니다',

        type = 'success',
        layout = 'topCenter',
        theme = 'unify--v1',

        isCloseButton = true,
        isProgressBar = true,
        timeOut = '1000'

    animationIn = 'fadeIn',
        animationOut = 'fadeOut',

        markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
        resultMarkup = function () {
            if (title != '' && msg != '') {
                return markup;
            } else {
                return markupDef;
            }
        };

    opts = {
        type: type,
        layout: layout,
        timeout: isProgressBar == true ? timeOut : false,
        animation: {
            open: 'animated ' + animationIn,
            close: 'animated ' + animationOut
        },
        closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
        text: resultMarkup(),
        theme: theme != '' ? theme : 'unify--v1'
    };

    var newNoty = new Noty(opts).show();

    $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');

}

function alertReviewDelete(){
    const title = '알림',
        msg = '리뷰를 삭제 하였습니다',

        type = 'success',
        layout = 'topCenter',
        theme = 'unify--v1',

        isCloseButton = true,
        isProgressBar = true,
        timeOut = '1000'

    animationIn = 'fadeIn',
        animationOut = 'fadeOut',

        markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
        resultMarkup = function () {
            if (title != '' && msg != '') {
                return markup;
            } else {
                return markupDef;
            }
        };

    opts = {
        type: type,
        layout: layout,
        timeout: isProgressBar == true ? timeOut : false,
        animation: {
            open: 'animated ' + animationIn,
            close: 'animated ' + animationOut
        },
        closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
        text: resultMarkup(),
        theme: theme != '' ? theme : 'unify--v1'
    };

    var newNoty = new Noty(opts).show();

    $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');

}

function alertLikeUpdate(){
    const title = '알림',
        msg = '상품을 추천 하였습니다',

        type = 'success',
        layout = 'topCenter',
        theme = 'unify--v1',

        isCloseButton = true,
        isProgressBar = true,
        timeOut = '1000'

    animationIn = 'fadeIn',
        animationOut = 'fadeOut',

        markup = '<div class="g-mr-20"><div class="noty_body__icon"><i class="hs-admin-check"></i></div></div><div>' + title + '<br>' + msg + '</div>',
        resultMarkup = function () {
            if (title != '' && msg != '') {
                return markup;
            } else {
                return markupDef;
            }
        };

    opts = {
        type: type,
        layout: layout,
        timeout: isProgressBar == true ? timeOut : false,
        animation: {
            open: 'animated ' + animationIn,
            close: 'animated ' + animationOut
        },
        closeWith: isCloseButton == true ? ['click', 'button'] : ['click'],
        text: resultMarkup(),
        theme: theme != '' ? theme : 'unify--v1'
    };

    var newNoty = new Noty(opts).show();

    $('#toastrOptions').text('var newNoty = new Noty(' + JSON.stringify(opts, null, 2) + ').show();');

}