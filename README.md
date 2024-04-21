# Match finder API



## Player Entity

- **By**: Mohammed alhajri
- **CRUD**
- **Endpoints**:
  1. `getPlayerById`: Retrieve player information by ID.
  2. `getPlayerCount`: get the number of all players.

## Team Entity

- **By**: Mohammed alhajri
- **CRUD**
- **Endpoints**:
  1. `getTeamById`: Retrieve team information by ID.
  2. `leaveTeam`: Remove a player from the team.
  3. `kickPlayer`: Remove a player forcefully from the team.
  4. `changeLeader`: Change the team leader.
  5. `getPlayerCountInTeam`: returns the number of players in the team.
  6. `getTeamMatches`: get all team matches. (By Khaled alkuhaily)

## JoinRequest Entity

- **By**: Mohammed alhajri
- **CRUD**
- **Endpoints**:
  1. `getRequestById`: Retrieve join request information by ID.
  2. `joinTeamStatus`: Accept or reject the request to join.
  3. `getAllTeamRequest`: Retrieve all join requests for a specific team.
  4. `getAllPlayerRequest`: Retrieve all join requests made by a player.
  5. `getRequestByStatusAndTeam`: Retrieve join requests based on status and team.

## Field Entity

- **By**: Khaled alkuhaily
- **CRUD**
- **Endpoints**:
  1. `getFieldById`: Retrieve field information by ID.
  2. `getFieldWithAvailableMatches`: Retrieve fields with available matches.
  3. `getFieldsByOrganizer`: Retrieve fields organized by a specific organizer.
  4. `getFieldsByLocation`: Retrieve fields by location.
  5. `getFieldsWithoutMatches`: Retrieve fields without matches scheduled.

## Organizer Entity

- **By**: Khaled alkuhaily
- **CRUD**
- **Endpoints**:
  1. `addResultToMatch`: Add a result to a match.
  2. `getAllMatchesByFieldId`: Retrieve all matches organized on a specific field.

## JoinMatchRequest Entity

- **By**: Khaled alkuhaily
- **CRUD**
- **Endpoints**:
  1. `acceptJoinMatchRequest`: Accept a join request for a match.
  2. `getJoinRequestByMatch`: Retrieve join requests for a specific match.
  3. `getRequestById`: Retrieve join request information by ID.

## Match Entity

- **By**: Ahmed alharbi
- **CRUD**
- **Endpoints**:
  1. `getMatchByAId`: Retrieve match information by ID.
  2. `getAvailableMatches`: Retrieve available matches.
