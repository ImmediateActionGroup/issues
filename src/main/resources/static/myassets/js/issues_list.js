/**
 * Created by beishan on 2017/6/25.
 */
$(document).ready(function () {
   console.info("hhhh");
   //var issues_list = $("#sprint_issues");
   var $issues_list = document.getElementById("sprint_issues");
   Sortable.create($issues_list, {
       group:"issues_list",
       animation:150
   });

   var $issues_backlog = document.getElementById("issues_backlog");
    Sortable.create($issues_backlog, {
        group:"issues_list",
        animation:150
    });
});