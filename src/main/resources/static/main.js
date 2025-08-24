let currentCoach = null;
let teamData = null;
let sessions = [];

function login() {
    const data = {
        email: document.getElementById("email")?.value,
        password: document.getElementById("password")?.value,
        role: document.getElementById("role")?.value
    };

    fetch("/login", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data)
    })
        .then(res => res.text())
        .then(msg => {
            if (msg.includes("/playerProfile")) {
                sessionStorage.setItem("playerEmail", data.email);
                window.location.href = "playerProfile.html";
            } else if (msg.includes("/coachProfile")) {
                sessionStorage.setItem("coachEmail", data.email);
                window.location.href = "coachProfile.html";
            } else {
                alert(msg);
            }
        })
        .catch(error => {
            console.error("Login failed:", error);
            alert("Login failed. Please try again.");
        });
}

function manageTeam() {
    if (!currentCoach || !currentCoach.teamId) {
        alert("No team assigned.");
        return;
    }
    sessionStorage.setItem("coachTeam", currentCoach.teamId);
    sessionStorage.setItem("coachTeamName", document.getElementById('coachTeam')?.textContent ?? "");
    window.location.href = "playersPerTeam.html";
}

function goToTrainingSessions() {
    if (!currentCoach || !currentCoach.id) {
        alert("Coach ID not available yet.");
        return;
    }
    sessionStorage.setItem("coachId", currentCoach.id);
    sessionStorage.setItem("coachTeamId", currentCoach.teamId);
    sessionStorage.setItem("coachName", currentCoach.name);
    window.location.href = "trainingSession.html";
}

function loadCoachProfile() {
    const email = sessionStorage.getItem("coachEmail");
    if (!email) {
        alert("Please login first.");
        window.location.href = "index.html";
        return;
    }

    fetch(`/coach/email/${encodeURIComponent(email)}`)
        .then(res => res.json())
        .then(coach => {
            currentCoach = coach;

            document.getElementById('coachImage')?.setAttribute("src", coach.image ?? "images/defaultPlayer.jpg");
            document.getElementById('coachName') && (document.getElementById('coachName').textContent = coach.name ?? "");
            document.getElementById('coachRole') && (document.getElementById('coachRole').textContent = coach.role ?? "");
            document.getElementById('coachEmail') && (document.getElementById('coachEmail').textContent = coach.email ?? "");
            document.getElementById('coachAge') && (document.getElementById('coachAge').textContent = coach.age ?? "");
            document.getElementById('coachPhone') && (document.getElementById('coachPhone').textContent = coach.phone ?? "");

            const coachTeam = document.getElementById('coachTeam');
            if (!coach.teamId) {
                coachTeam && (coachTeam.textContent = 'No team assigned');
            } else {
                fetch(`/team/${coach.teamId}`)
                    .then(res => {
                        if (!res.ok) throw new Error('Team not found');
                        return res.json();
                    })
                    .then(team => {
                        coachTeam && (coachTeam.textContent = team.name ?? "No team");
                        sessionStorage.setItem("coachTeamName", team.name ?? "No team");
                    })
                    .catch(err => {
                        console.error("Failed to load team:", err);
                        coachTeam && (coachTeam.textContent = 'Unknown team');
                    });
            }
        })
        .catch(err => {
            console.error("Failed to load coach:", err);
            alert("Error loading profile");
        });
}

function loadPlayerProfile() {
    const email = sessionStorage.getItem("playerEmail");
    if (!email) {
        alert("Please login first.");
        window.location.href = "index.html";
        return;
    }

    fetch(`/player/email/${encodeURIComponent(email)}`)
        .then(res => {
            if (!res.ok) throw new Error("Failed to fetch player");
            return res.json();
        })
        .then(player => {
            sessionStorage.setItem("playerId", player.id);

            document.getElementById('playerImage')?.setAttribute("src", player.image ?? "images/defaultPlayer.jpg");
            document.getElementById('playerName') && (document.getElementById('playerName').textContent = player.name ?? "");
            document.getElementById('playerPosition') && (document.getElementById('playerPosition').textContent = player.position ?? "");
            document.getElementById('playerAge') && (document.getElementById('playerAge').textContent = player.age ?? "");
            document.getElementById('playerRole') && (document.getElementById('playerRole').textContent = player.role ?? "");
            document.getElementById('playerEmail') && (document.getElementById('playerEmail').textContent = player.email ?? "");
            document.getElementById('playerPhone') && (document.getElementById('playerPhone').textContent = player.phone ?? "");
            document.getElementById('playerGoals') && (document.getElementById('playerGoals').textContent = player.stats?.goals ?? "0");
            document.getElementById('playerAssists') && (document.getElementById('playerAssists').textContent = player.stats?.assists ?? "0");
            document.getElementById('playerCompletedPasses') && (document.getElementById('playerCompletedPasses').textContent = player.stats?.passesCompleted ?? "0");
            document.getElementById('playerDistanceCovered') && (document.getElementById('playerDistanceCovered').textContent = player.stats?.distanceCovered ?? "0");
            document.getElementById('playerStamina') && (document.getElementById('playerStamina').textContent = player.fitness?.stamina ?? "N/A");
            document.getElementById('playerSpeed') && (document.getElementById('playerSpeed').textContent = player.fitness?.speed ?? "N/A");
            document.getElementById('playerStrength') && (document.getElementById('playerStrength').textContent = player.fitness?.strength ?? "N/A");
            document.getElementById('playerAgility') && (document.getElementById('playerAgility').textContent = player.fitness?.agility ?? "N/A");
            document.getElementById('playerInjured') && (document.getElementById('playerInjured').textContent = player.injured ? "Injured" : "Not Injured");

            if (!player.teamId) {
                document.getElementById('playerTeam') && (document.getElementById('playerTeam').textContent = 'No team assigned');
            } else {
                fetch(`/team/${player.teamId}`)
                    .then(res => res.json())
                    .then(team => {
                        document.getElementById('playerTeam') && (document.getElementById('playerTeam').textContent = team.name ?? "No team");
                    })
                    .catch(err => {
                        console.error("Failed to load team:", err);
                        document.getElementById('playerTeam') && (document.getElementById('playerTeam').textContent = 'Unknown team');
                    });
            }

            const btn = document.getElementById("goToMedicalReportBtn");
            if (btn) {
                btn.addEventListener("click", () => {
                    const id = sessionStorage.getItem("playerId");
                    if (!id) {
                        alert("Player ID not found. Try reloading.");
                        return;
                    }
                    window.location.href = `medicalReport.html?playerId=${id}`;
                });
            }
        })
        .catch(err => {
            console.error("Failed to load player:", err);
            alert("Error loading profile");
        });
}

function loadTeam(teamId) {
    fetch(`/team/${teamId}`)
        .then(res => res.json())
        .then(team => {
            teamData = team;

            document.getElementById("teamName").textContent = team.name;
            document.getElementById("coachName").textContent = team.coachName;

            const playersList = document.getElementById("playersList");
            const removeSelect = document.getElementById("removePlayerSelect");
            const injurySelect = document.getElementById("injuryPlayerSelect");

            playersList.innerHTML = "";
            removeSelect.innerHTML = "";
            injurySelect.innerHTML = "";

            if (team.playersIds?.length > 0) {
                team.playersIds.forEach(pid => {
                    fetch(`/player/id/${pid}`)
                        .then(res => res.json())
                        .then(player => {
                            const li = document.createElement("li");
                            li.textContent = `${player.name} (${player.position ?? "No position"}) - ${player.injured ? "Injured" : "Healthy"}`;
                            playersList.appendChild(li);

                            [removeSelect, injurySelect].forEach(sel => {
                                const option = document.createElement("option");
                                option.value = pid;
                                option.textContent = player.name;
                                sel.appendChild(option);
                            });
                        })
                        .catch(() => {
                            const li = document.createElement("li");
                            li.textContent = "Error loading player";
                            playersList.appendChild(li);
                        });
                });
            } else {
                playersList.innerHTML = "<li>No players assigned</li>";
            }
        })
        .catch(err => {
            console.error("Error loading team data:", err);
            document.getElementById("teamName").textContent = "Error loading data";
        });
}

function addPlayer() {
    const playerEmail = document.getElementById("newPlayerEmail").value.trim();
    if (!playerEmail) {
        alert("Enter a valid player email");
        return;
    }

    fetch(`/team/${teamData.id}/addPlayer/${playerEmail}`, { method: "POST" })
        .then(res => res.ok ? res.text() : res.text().then(msg => { throw new Error(msg); }))
        .then(msg => {
            alert(msg);
            loadTeam(teamData.id);
        })
        .catch(err => {
            console.error(err);
            alert(err.message);
        });
}

function removePlayer() {
    const playerId = document.getElementById("removePlayerSelect").value;
    if (!playerId) {
        alert("Select a player to remove");
        return;
    }

    fetch(`/team/${teamData.id}/removePlayer?playerId=${playerId}`, { method: "DELETE" })
        .then(res => res.ok ? res.text() : Promise.reject("Failed to remove player"))
        .then(() => {
            alert("Player removed successfully!");
            loadTeam(teamData.id);
        })
        .catch(err => {
            console.error(err);
            alert(err);
        });
}

function updateInjuryStatus() {
    const playerId = document.getElementById("injuryPlayerSelect").value;
    const injuryStatus = document.getElementById("injuryStatusSelect").value;

    if (!playerId) {
        alert("Please select a player");
        return;
    }

    fetch(`/player/${playerId}/${injuryStatus}`, { method: "PUT" })
        .then(res => res.ok ? res.text() : Promise.reject("Failed to update injury status"))
        .then(msg => {
            alert(msg);
            loadTeam(teamData.id);
        })
        .catch(err => {
            console.error(err);
            alert(err);
        });
}

function getPlayerId() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get("playerId") || sessionStorage.getItem("playerId");
}

function loadMedicalRecord(playerId) {
    if (!playerId) {
        alert("No player ID provided.");
        return;
    }

    fetch(`/medicalRecord/${playerId}`)
        .then(res => res.ok ? res.json() : Promise.reject("Failed to fetch medical record"))
        .then(record => {
            document.getElementById("playerStatus").textContent = record.player?.injured ? "Injured" : "Healthy";

            const injuryTable = document.getElementById("injuryTable").querySelector("tbody");
            injuryTable.innerHTML = "";
            if (record.injuryHistory?.length > 0) {
                document.getElementById("injurySummary").textContent = `${record.injuryHistory.length} injuries recorded`;
                record.injuryHistory.forEach(injury => {
                    const tr = document.createElement("tr");
                    tr.className = injury.recovered ? "recovered" : "ongoing";
                    tr.innerHTML = `
                        <td>${injury.type ?? "N/A"}</td>
                        <td>${injury.injuryDate ? new Date(injury.injuryDate).toLocaleDateString() : "N/A"}</td>
                        <td>${injury.expectedRecoveryDate ? new Date(injury.expectedRecoveryDate).toLocaleDateString() : "N/A"}</td>
                        <td>${injury.recovered ? "Recovered" : "Ongoing"}</td>`;
                    injuryTable.appendChild(tr);
                });
            } else {
                document.getElementById("injurySummary").textContent = "No injury records";
                injuryTable.innerHTML = `<tr><td colspan="4" style="text-align:center;">No injury records</td></tr>`;
            }

            const checkupTable = document.getElementById("checkupTable").querySelector("tbody");
            checkupTable.innerHTML = "";
            if (record.checkups?.length > 0) {
                document.getElementById("checkupSummary").textContent = `${record.checkups.length} checkups recorded`;
                record.checkups.forEach(checkup => {
                    const tr = document.createElement("tr");
                    tr.innerHTML = `
                        <td>${checkup.date ? new Date(checkup.date).toLocaleDateString() : "N/A"}</td>
                        <td>${checkup.doctorName ?? "N/A"}</td>
                        <td>${checkup.notes ?? "N/A"}</td>`;
                    checkupTable.appendChild(tr);
                });
            } else {
                document.getElementById("checkupSummary").textContent = "No checkup records";
                checkupTable.innerHTML = `<tr><td colspan="3" style="text-align:center;">No checkup records</td></tr>`;
            }
        })
        .catch(err => {
            console.error("Error loading medical record:", err);
            alert("Failed to load medical record.");
        });
}

function renderSessions() {
    const list = document.getElementById("sessionsList");
    list.innerHTML = "";
    sessions.forEach(s => {
        const div = document.createElement("div");
        div.className = "session-item";
        div.innerHTML = `
            <p><b>Date:</b> ${s.date}</p>
            <p><b>Focus Area:</b> ${s.focusArea}</p>
            <p><b>Description:</b> ${s.drillDescription}</p>
            <p><b>Team:</b> ${s.teamName}</p>
            <p><b>Coach:</b> ${s.coachName}</p>`;
        list.appendChild(div);
    });
}

function loadTrainingSessions() {
    const coachName = sessionStorage.getItem("coachName");
    fetch(`/trainingSession/coach/${coachName}`)
        .then(res => res.json())
        .then(data => {
            sessions = data;
            renderSessions();
        })
        .catch(err => console.error("Error loading sessions:", err));

    const form = document.getElementById("sessionForm");
    if (form) {
        form.addEventListener("submit", e => {
            e.preventDefault();
            const newSession = {
                date: document.getElementById("date").value,
                focusArea: document.getElementById("focusArea").value,
                drillDescription: document.getElementById("drillDescription").value,
                teamName: sessionStorage.getItem("coachTeamName"),
                coachName: sessionStorage.getItem("coachName"),
            };

            fetch("/trainingSession/add", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(newSession)
            })
                .then(res => res.json())
                .then(saved => {
                    sessions.push(saved);
                    renderSessions();
                    form.reset();
                })
                .catch(err => console.error("Error saving session:", err));
        });
    }
}

document.addEventListener("DOMContentLoaded", () => {
    const path = window.location.pathname;

    if (path.includes("coachProfile.html")) {
        loadCoachProfile();
    } else if (path.includes("playerProfile.html")) {
        loadPlayerProfile();
    } else if (path.includes("playersPerTeam.html")) {
        const teamId = sessionStorage.getItem("coachTeam");
        if (!teamId) {
            alert("Please login first.");
            window.location.href = "index.html";
        } else {
            loadTeam(teamId);
        }
    } else if (path.includes("medicalReport.html")) {
        loadMedicalRecord(getPlayerId());
    } else if (path.includes("trainingSession.html")) {
        loadTrainingSessions();
    }
});
