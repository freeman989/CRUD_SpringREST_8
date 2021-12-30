showHeader();
showUserInfo();

function showHeader() {
    fetch('http://localhost:8080/getAuthorized')
        .then(response => response.json())
        .then(user => {

            //заполняем статусбар
            document.getElementById("header_email").innerHTML = user.email;

            let rolesList = document.createElement('ul');
            for (let i = 0; i < user.roles.length; i++) {
                let role = document.createElement('li');
                role.textContent = user.roles[i].roleName + " ";
                rolesList.appendChild(role);
            }
            document.getElementById("header_roles").innerHTML = 'with roles: ' + rolesList.textContent;
        });
}

function showUserInfo(user) {
    fetch('http://localhost:8080/getAuthorized')
        .then(response => response.json())
        .then(user => {
            let tBody = document.getElementById("user_info");
            tBody.innerHTML = "";

            let row = tBody.insertRow(0);
            let cell0 = row.insertCell(0);
            cell0.innerHTML = user.id;
            let cell1 = row.insertCell(1);
            cell1.innerHTML = user.name;
            let cell2 = row.insertCell(2);
            cell2.innerHTML = user.lastName;
            let cell3 = row.insertCell(3);
            cell3.innerHTML = user.age;
            let cell4 = row.insertCell(4);
            cell4.innerHTML = user.email;
            let cell5 = row.insertCell(5);
            cell5.innerHTML = listRoles(user).textContent;
        });
}

function listRoles(user) {
    let rolesList = document.createElement('ul');

    for (let i = 0; i < user.roles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.roles[i].roleName + " ";
        rolesList.appendChild(role);
    }

    return rolesList;
}