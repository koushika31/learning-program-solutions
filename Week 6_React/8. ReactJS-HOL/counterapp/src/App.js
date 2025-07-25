import React, { Component } from "react";
import "./App.css";

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 0,
      exitCount: 0,
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
    }));
  };

  render() {
    return (
      <div className="container">
        <table>
          <tbody>
            <tr>
              <td>
                <button className="btn" onClick={this.updateEntry}>Login</button>
                <span className="text"> {this.state.entryCount} People Entered!!!</span>
              </td>
              <td>
                <button className="btn" onClick={this.updateExit}>Exit</button>
                <span className="text"> {this.state.exitCount} People Left!!!</span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}

export default CountPeople;
