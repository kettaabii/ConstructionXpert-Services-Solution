var taskTitles = [];
var taskDescriptions = [];
var taskStartDates = [];
var taskEndDates = [];

document.getElementById("addTaskButton").addEventListener("click", function() {
    // Hide the existing form

    taskTitles.push(document.getElementById("taskTitle").value);
    taskDescriptions.push(document.getElementById("taskDescription").value);
    taskStartDates.push(document.getElementById("taskStartDate").value);
    taskEndDates.push(document.getElementById("taskEndDate").value);

    document.getElementById("taskTitle").value = "";
    document.getElementById("taskDescription").value = "";
    document.getElementById("taskStartDate").value= "";
    document.getElementById("taskEndDate").value = "";
    addTaskTitles();
    console.log(taskTitles, taskDescriptions, taskStartDates, taskEndDates);
});
function addTaskTitles() {
    var taskToastContainer = document.getElementById("tasktoast");
    taskToastContainer.innerHTML = "";

    for (var i = 0; i < taskTitles.length; i++) {
        var taskTitle = taskTitles[i];

        var taskToast = document.createElement("div");
        taskToast.className = "task-toast-container";
        taskToast.style.border = "1px solid orange";
        taskToast.style.borderRadius = "6px";

        var closeButton = document.createElement("button");
        closeButton.className = "btn-close";
        closeButton.textContent = "×";

        var taskContent = document.createElement("p");
        taskContent.className = "text-content";
        taskContent.textContent = taskTitle;

        taskToast.appendChild(closeButton);
        taskToast.appendChild(taskContent);

        taskToastContainer.appendChild(taskToast);
    }
}



function sendData(event) {
    event.preventDefault();
    var projectName = document.getElementById("projectName").value;
    var startDate = document.getElementById("startDate").value;
    var endDate = document.getElementById("endDate").value;
    var description = document.getElementById("description").value;
    var budget = document.getElementById("budget").value;
    console.log(taskTitles, taskDescriptions, taskStartDates, taskEndDates);
    fetch("http://localhost:8080/ConstructionXpertServices_war_exploded/addPojectTask", {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            projectName: projectName,
            startDate: startDate,
            endDate: endDate,
            description: description,
            budget: budget,
            taskTitle: [...taskTitles],
            taskDescription: [...taskDescriptions],
            taskStartDate: [...taskStartDates],
            taskEndDate: [...taskEndDates]
        })
    }).then(response => response.json())
        .then(data => {
            if (data.success) {
                window.location.href = data.redirect;
            }
        })

}