const dom = function(lang) {

    let en = {
        buttonSubmit: 'Accept',
        login: 'Login',
        loginPlaceholder: 'Enter login',
        password: 'Password',
        passwordPlaceholder: 'Enter password',
        passwordRepeat: 'Repeat password',
        passwordRepeatPlaceholder: 'Enter password again',
        buttonRegistration: 'Register',
        buttonLogout: 'Log out',
        buttonLogin: 'Log in',
        buttonLoginAsGuest: 'Login as guest',
    };

    let ru = {
        buttonSubmit: 'Подтвердить',
        login: 'Логин',
        loginPlaceholder: 'Введите логин',
        password: 'Пароль',
        passwordPlaceholder: 'Введите пароль',
        passwordRepeat: 'Повторите пароль',
        passwordRepeatPlaceholder: 'Повторите ввод пароля',
        buttonRegistration: 'Зарегистрироваться',
        buttonLogout: 'Выйти',
        buttonLogin: 'Войти',
        buttonLoginAsGuest: 'Войти как гость',
        driverNum: 'Номер водителя',
        driverNumPlaceholder: 'Введите номер водителя',
        autoNum: 'Номер автомобиля',
        autoNumPlaceholder: 'Введите номер автомобиля',
        tripNum: 'Номер рейса',
        tripNumPlaceholder: 'Введите номер рейса'
    };

    function getLocale(lang) {
        return lang === 'ru' ? ru : en;
    }

    let locale = getLocale(lang);

    var formId = "";

    const loginFrom = {
        login: {
            label: locale['login'],
            type: 'text',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input'
        },
        password: {
            label: locale['password'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLogin']
        }
    };

    const guestForm = {
        login: {
            type: 'hidden',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input'
        },
        password: {
            type: 'hidden',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLoginAsGuest']
        }
    };

    const logoutForm = {
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonLogout']
        }
    };

    const registrationForm = {
        login: {
            label: locale['login'],
            type: 'text',
            class: 'form-control',
            placeholder: locale['loginPlaceholder'],
            name: 'login',
            id: 'login-input'
        },
        password: {
            label: locale['password'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordPlaceholder'],
            name: 'password',
            id: 'password-input'
        },
        repeatPassword: {
            label: locale['passwordRepeat'],
            type: 'password',
            class: 'form-control',
            placeholder: locale['passwordRepeatPlaceholder'],
            name: 'repeat-password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonRegistration']
        }
    };

    const tripsByDriverForm = {
        driverId: {
            label: locale['driverNum'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['driverNumPlaceholder'],
            name: 'driverId',
            minValue: '1',
            step: '1',
            id: 'driverId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    const setCarStatusForm = {
        carId: {
            label: locale['autoNum'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['autoNumPlaceholder'],
            name: 'carId',
            minValue: '1',
            step: '1',
            id: 'carId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    const setDriverForm = {
        tripId: {
            label: locale['tripNum'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['tripNumPlaceholder'],
            name: 'tripId',
            minValue: '1',
            step: '1',
            id: 'tripId-input',
        },
        driverId: {
            label: locale['driverNum'],
            type: 'number',
            class: 'form-control',
            placeholder: locale['driverNumPlaceholder'],
            name: 'driverId',
            minValue: '1',
            step: '1',
            id: 'driverId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: locale['buttonSubmit']
        }
    };

    function buildForm(form, type) {
        var array;
        var actionValue;
        switch (type) {
            case 'tripsByDriverForm':
                array = tripsByDriverForm;
                actionValue = "tripsById";
                break;
            case 'setCarStatusForm':
                array = setCarStatusForm;
                actionValue = "setCarStatus";
                break;
            case 'setDriverForm':
                array = setDriverForm;
                actionValue = "setDriver";
                break;
            case 'loginForm':
                array = loginFrom;
                actionValue = 'login';
                break;
            case 'guestForm':
                array = guestForm;
                actionValue = 'login';
                break;
            case 'logoutForm':
                array = logoutForm;
                actionValue = 'logout';
                break;
            case 'registrationForm':
                array = registrationForm;
                actionValue = 'registration';
                break;
        }


        for(const prop in array) {
            switch (array[prop].type) {
                default:
                    const formDiv = document.createElement('div');
                    formDiv.setAttribute('class', 'form-group');

                    const label = document.createElement('label');
                    label.innerHTML = array[prop].label;
                    formDiv.appendChild(label);

                    const input = document.createElement('input');
                    input.setAttribute('type', array[prop].type);
                    input.setAttribute('class', array[prop].class);
                    input.setAttribute('placeholder', array[prop].placeholder);
                    input.setAttribute('name', array[prop].name);
                    input.setAttribute('min', array[prop].minValue);
                    input.setAttribute('step', array[prop].step);
                    input.setAttribute("id", array[prop].id);
                    input.required = true;
                    formDiv.appendChild(input);

                    form.appendChild(formDiv);
                    break;
                case "submit":
                    const hiddenInput = document.createElement('input');
                    hiddenInput.setAttribute('name', 'action');
                    hiddenInput.setAttribute('type', 'hidden');
                    hiddenInput.setAttribute('id', 'action');
                    hiddenInput.setAttribute('value', actionValue);
                    form.appendChild(hiddenInput);

                    const submit = document.createElement('input');
                    submit.setAttribute('type', array[prop].type);
                    submit.setAttribute('class', array[prop].class);
                    submit.value = array[prop].value;

                    form.appendChild(submit);
                    break;
            }
        }
    }


    function initPage() {

        const tripsByDriverForm = document.getElementById('trips-by-driver-form');
        if (tripsByDriverForm != null) {
            buildForm(tripsByDriverForm, 'tripsByDriverForm');
            console.log('tripsByDriverForm');
            formId = 'trips-by-driver-form';
            return
        }

        const setCarStatusForm = document.getElementById('set-car-status-form');
        if (setCarStatusForm != null) {
            buildForm(setCarStatusForm, 'setCarStatusForm');
            console.log('setCarStatusForm');
            formId = 'set-car-status-form';
            return;
        }

        const setDriverForm = document.getElementById('set-driver-form');
        if (setDriverForm != null) {
            buildForm(setDriverForm, 'setDriverForm');
            console.log('setDriverForm');
            formId = 'set-driver-form';
        }

        const loginForm = document.getElementById('login-form');
        if (loginForm != null) {
            buildForm(loginForm, 'loginForm');
            console.log('loginForm');
            formId = 'login-form';
        }

        const guestForm = document.getElementById('as-guest-form');
        if (guestForm != null) {
            buildForm(guestForm, 'guestForm');
            console.log('guestForm');
            formId = 'as-guest-form';
        }

        const logoutForm = document.getElementById('logout-form');
        if (logoutForm != null) {
            buildForm(logoutForm, 'logoutForm');
            console.log('logoutForm');
            formId = 'logout-form';
        }

        const registrationForm = document.getElementById('registration-form');
        if (registrationForm != null) {
            buildForm(registrationForm, 'registrationForm');
            console.log('registrationForm');
            formId = 'registration-form';
        }


    }

    return {
        initPage
    }
};
