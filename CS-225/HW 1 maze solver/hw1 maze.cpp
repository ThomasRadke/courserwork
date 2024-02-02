#include <iostream>
#include <fstream>
#include <string>

using namespace std;

class Maze {
public:
	void print();
	//bool escaped(int CurrentPosR, int CurrentPosC);
	bool Solve();
	Maze(ifstream& inFile);
	Maze(const Maze& anotherMaze);
	void move(char maze[][12], int CPosRow, int CPosCol, int letterCount, bool& Escaped);
private:
	char maze[12][12];
	int maxRows;
	int maxCols;
};





int main() {
	ifstream inFile;
	string fileName;
	int row, col;
	fileName = "maze.in";
	inFile.open(fileName.c_str());
	Maze maze(inFile);
	maze.print();
	maze.Solve();
	return 0;
}

void Maze::print() {
	int r;
	int c;
	for (r = 1; r <= maxRows; r++) {
		for (c = 1; c <= maxCols; c++)
			cout << maze[r][c];
		cout << endl;
	}
}

void Maze::move(char maze[][12], int CPosRow, int CPosCol, int letterCount, bool& Escaped) {
	char list[26] = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	bool path = false;
	for (int i = 0; i < 26; i++) {
		if (list[i] == maze[CPosRow][CPosCol]) {
			path = true;
			break;
		}
	}
	if (letterCount >= 122) {
		letterCount = 97;
	}
	if (!Escaped && !path && maze[CPosRow][CPosCol] != '*')
		if (CPosRow == maxRows && CPosCol == maxCols) {
			maze[CPosRow][CPosCol] = char(letterCount);
			cout << "Escaped" << endl;
			Escaped = true;
			return;
	}

	else {
		maze[CPosRow][CPosCol] = char(letterCount);
		if (CPosRow != maxRows && !Escaped) {
			maze[CPosRow][CPosCol] = char(letterCount);
			letterCount++;
			move(maze, CPosRow + 1, CPosCol, letterCount, Escaped);
		}
		if (CPosCol != maxCols && !Escaped) {
			maze[CPosRow][CPosCol] = char(letterCount);
			letterCount++;
			move(maze, CPosRow, CPosCol + 1, letterCount, Escaped);
		}
		if (!Escaped) {
			maze[CPosRow][CPosCol] = '.';
			//letterCount++;
			move(maze, CPosRow - 1, CPosCol, letterCount, Escaped);
		}

		 if (!Escaped) {
			maze[CPosRow][CPosCol] = '.';
			//letterCount++;
			move(maze, CPosRow, CPosCol - 1, letterCount, Escaped);
		}
	}
}

Maze::Maze(ifstream& inFile) {
	int rowIndex, colIndex;
	inFile >> maxRows >> maxCols;
	string row;
	for (rowIndex = 1; rowIndex <= maxRows; rowIndex++) {
		inFile >> row;
		for (colIndex = 1; colIndex <= maxCols; colIndex++)
			maze[rowIndex][colIndex] = row[colIndex - 1];
		maze[rowIndex][0] = '*';
		maze[rowIndex][maxCols + 1] = '*';
	}
	for (colIndex = 0; colIndex <= maxCols + 1; colIndex++) {
		maze[0][colIndex] = '*';
		maze[maxRows + 1][colIndex] = '*';
	}
}

Maze::Maze(const Maze& anotherMaze) {
	maxRows = anotherMaze.maxRows;
	maxCols = anotherMaze.maxCols;
	for (int rowIndex = 0; rowIndex <= maxRows + 1; rowIndex++)
		for (int colIndex = 0; colIndex <= maxCols + 1; colIndex++)
			maze[rowIndex][colIndex] = anotherMaze.maze[rowIndex][colIndex];
}

bool Maze::Solve() {
	bool Escaped = false;
	move(maze, 1, 1, 97, Escaped);
	if (Escaped == false)
		cout << "Impossible";
	for (int r = 0; r <= maxRows; r++) {
		for (int c = 0; c <= maxCols; c++) {
			cout << maze[r][c];
		}
		cout << endl;
	}
	return true;
}
//bool Maze::escaped(int CurrentPosR, int CurrentPosC) {
//	bool escaped = false;
//	if (CurrentPosR == maxRows && CurrentPosC == maxCols){
//		bool escaped = true;
//		return escaped;
//	}
//	return false;
//}