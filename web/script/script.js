const dom = (function() {

    var formId = "";

    const loginFrom = {
        login: {
            label: 'Логин',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login',
            id: 'login-input'
        },
        password: {
            label: 'Пароль',
            type: 'password',
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Войти'
        }
    };

    const guestForm = {
        login: {
            type: 'hidden',
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login',
            id: 'login-input'
        },
        password: {
            type: 'hidden',
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Войти как гость'
        }
    };

    const logoutForm = {
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Выйти'
        }
    };

    const registrationForm = {
        login: {
            label: 'Логин',
            type: 'text',
            class: 'form-control',
            placeholder: 'Введите логин',
            name: 'login',
            id: 'login-input'
        },
        password: {
            label: 'Пароль',
            type: 'password',
            class: 'form-control',
            placeholder: 'Введите пароль',
            name: 'password',
            id: 'password-input'
        },
        repeatPassword: {
            label: 'Повтор пароля',
            type: 'password',
            class: 'form-control',
            placeholder: 'Повторите пароль',
            name: 'repeat-password',
            id: 'password-input'
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Зарегистрироваться'
        }
    };

    const tripsByDriverForm = {
        driverId: {
            label: 'Номер водителя',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер водителя',
            name: 'driverId',
            minValue: '1',
            step: '1',
            id: 'driverId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    const setCarStatusForm = {
        carId: {
            label: 'Номер автомобиля',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер автомобиля',
            name: 'carId',
            minValue: '1',
            step: '1',
            id: 'carId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
        }
    };

    const setDriverForm = {
        tripId: {
            label: 'Номер рейса',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер рейса',
            name: 'tripId',
            minValue: '1',
            step: '1',
            id: 'tripId-input',
        },
        driverId: {
            label: 'Номер водителя',
            type: 'number',
            class: 'form-control',
            placeholder: 'Введите номер водителя',
            name: 'driverId',
            minValue: '1',
            step: '1',
            id: 'driverId-input',
        },
        submitButton: {
            type: 'submit',
            class: 'btn btn-primary',
            value: 'Подтвердить'
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
}());

dom.initPage();
