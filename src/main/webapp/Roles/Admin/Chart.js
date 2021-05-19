function load(){
    var ctx = document.getElementById('myChart').getContext('2d');
    var labelsValues = document.getElementById('labels').value.split(",");
    var statesValues = document.getElementById('values').value.split(",").map(Number);
    alert(statesValues);
    var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: labelsValues,
            datasets: [{
                data: statesValues,
                backgroundColor: [
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(255, 99, 132, 0.2)' 
                ],
                borderColor: [
                    'rgb(54, 162, 235)',
                    'rgb(255, 206, 86)',
                    'rgb(75, 192, 192)',
                    'rgb(255, 99, 132)'
                ],
                borderWidth: 1
            }]
        },
        options: {
        }
    });
}

window.onload = load();