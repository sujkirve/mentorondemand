import React, { Component } from 'react';
import dayjs from 'dayjs';

import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import Snackbar from '@material-ui/core/Snackbar';

export default class MentorSearch extends Component {
  state = {
    searchTerm: '',
    mentors: [],
    dialogOpen: false,
    proposedMentor: {},
    trainingStartDate: dayjs().format('YYYY-MM-DD'),
    proposedTrainingDuration: 0,
    isSnackbarOpen: false,
    snackbarMessage: ''
  };

  constructor(props) {
    super(props);

    console.log('props: ', props);
    this.props = props;
  }

  handleClickOpen = () => {
    this.setState({ dialogOpen: true });
  };

  handleClose = () => {
    this.setState({ dialogOpen: false });
  };

  handleSendProposal = mentor => {
    this.setState({
      proposedMentor: mentor
    });

    this.handleClickOpen();
  };

  handleSendProposalRequest = () => {
    this.handleClose();

    fetch(`http://localhost:3001/proposals`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        mentor: this.state.proposedMentor,
        user: this.props.userProfile,
        duration: this.state.proposedTrainingDuration,
        trainingStartDate: this.state.trainingStartDate,
        isAcceptd: false,
        mentorFees:
          this.state.proposedMentor.mentorFees *
          this.state.proposedTrainingDuration,
        paymentStatus: {
          phase1: false,
          phase2: false,
          phase3: false,
          phase4: false
        }
      })
    });

    this.setState({
      isSnackbarOpen: true,
      snackbarMessage: `Mentor Request Sent Successfully.`
    });
  };

  handleSnackbarClose = () => {
    this.setState({
      isSnackbarOpen: false,
      snackbarMessage: ``
    });
  };

  handleSearchTermChange = event => {
    this.setState({
      searchTerm: event.target.value
    });

    fetch(`http://localhost:3001/mentors?technologies=${event.target.value}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(resp => resp.json())
      .then(resp => {
        this.setState({
          mentors: resp
        });
      });
  };
  handleChange = name => event => {
    this.setState({
      [name]: event.target.value
    });
  };
  render() {
    return (
      <div className="mentor-search-container">
        <div className="search-field-container">
          <TextField
            id="userId"
            label="Enter Technology To Find Mentors For"
            // className={classes.textField}
            value={this.state.searchTerm}
            onChange={this.handleSearchTermChange}
            margin="normal"
            fullWidth
            variant="filled"
          />
        </div>
        <div className="search-results-container">
          {this.state.mentors.map((mentor, index) => (
            <div className="result-card" key={index}>
              <h3>{mentor.mentorName}</h3>
              <h5>{mentor.mentorEmail}</h5>
              <h4 className="years-labels">
                Years of Expirience: {mentor.yearOfExp}
              </h4>
              <h5>Fees: ₹{mentor.mentorFees.toLocaleString('en-in')}</h5>

              <Button
                variant="contained"
                color="primary"
                size="small"
                className="send-proposal-btn"
                onClick={() => this.handleSendProposal(mentor)}
              >
                Request
              </Button>
            </div>
          ))}
        </div>
        <Dialog
          open={this.state.dialogOpen}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">Request Training</DialogTitle>
          <DialogContent>
            <DialogContentText>
              Please fill following details which will be sent to the mentor for
              their approval.
            </DialogContentText>
            <TextField
              autoFocus
              margin="dense"
              id="name"
              label="Training Start Date"
              type="date"
              fullWidth
              InputLabelProps={{ shrink: true }}
              value={this.state.trainingStartDate}
              onChange={this.handleChange('trainingStartDate')}
            />
            <TextField
              autoFocus
              margin="dense"
              id="name"
              label="Training Duration(In Months)"
              fullWidth
              type="number"
              InputLabelProps={{ shrink: true }}
              value={this.state.proposedTrainingDuration}
              onChange={this.handleChange('proposedTrainingDuration')}
            />
          </DialogContent>
          <DialogActions>
            <Button
              onClick={this.handleSendProposalRequest}
              color="primary"
              variant="contained"
            >
              Send Proposal
            </Button>
          </DialogActions>
        </Dialog>
        <Snackbar
          anchorOrigin={{ vertical: 'bottom', horizontal: 'right' }}
          key={'mentorSearchSnackBar'}
          open={this.state.isSnackbarOpen}
          onClose={this.handleSnackbarClose}
          ContentProps={{
            'aria-describedby': 'message-id'
          }}
          message={<span id="message-id">{this.state.snackbarMessage}</span>}
        />
      </div>
    );
  }
}
