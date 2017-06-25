/**
 * Created by beishan on 2017/6/25.
 */
$(document).ready(function () {
    console.info("hhhh");
    //var issues_list = $("#sprint_issues");
    var $issues_todo = document.getElementById("issues_todo");
    Sortable.create($issues_todo, {
        group:"sprint_issues",
        animation:150
    });

    var $issues_inprogress = document.getElementById("issues_inprogress");
    Sortable.create($issues_inprogress, {
        group:"sprint_issues",
        animation:150
    });

    var $issues_done = document.getElementById("issues_done");
    Sortable.create($issues_done, {
        group:"sprint_issues",
        animation:150
    });
});