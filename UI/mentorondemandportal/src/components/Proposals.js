import React from 'react';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

export default class Proposals extends React.Component {
  state = {
    proposals: []
  };

  constructor(props) {
    super(props);
    this.props = props;
  }

  componentDidMount() {
    fetch(`http://localhost:3001/proposals`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(resp => resp.json())
      .then(proposals => {
        this.setState({
          proposals
        });
      });
  }

  handleAcceptProposal = proposal => {
    fetch(`http://localhost:3001/proposals/${proposal.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        ...proposal,
        isAcceptd: true
      })
    })
      .then(resp => resp.json())
      .then(proposal => {
        const acceptedProposalIndex = this.state.proposals.findIndex(
          proposalObj => proposalObj.id === proposal.id
        );

        this.setState({
          proposals: [
            ...this.state.proposals.slice(0, acceptedProposalIndex),
            proposal,
            ...this.state.proposals.slice(acceptedProposalIndex + 1)
          ]
        });
      });
  };

  blockUser = (proposal) => {
    fetch(`http://localhost:3001/mentors/${proposal.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        ...proposal,
        blockedUsers: proposal.user.id
      })
    })
      .then(resp => resp.json())
      .then(proposal => {
        const acceptedProposalIndex = this.state.proposals.findIndex(
          proposalObj => proposalObj.id === proposal.id
        );

        this.setState({
          proposals: [
            ...this.state.proposals.slice(0, acceptedProposalIndex),
            proposal,
            ...this.state.proposals.slice(acceptedProposalIndex + 1)
          ]
        });
      });
  }

  render() {
    const { role } = this.props.userProfile;
    return (
      <div className="proposals-container">
        <h1>Proposals</h1>
        {this.state.proposals
          .filter(proposal => {
            if (role === 'mentor') {
              return (
                proposal.mentor.mentorId === this.props.userProfile.mentorId
              );
            } else {
              return proposal.user.id === this.props.userProfile.id;
            }
          })
          .map(proposal => {
            if (role === 'mentor') {
              return (
                <div className="result-card" key={proposal.id}>
                  <h3>Propposer: {proposal.user.name}</h3>
                  <div>Training Start Date: {proposal.trainingStartDate}</div>
                  <div>Training Duration: {proposal.duration}</div>
                  <div>Training Fees: {proposal.mentorFees}</div>
                  {!proposal.isAcceptd ? (
                    <Button
                      variant="contained"
                      color="primary"
                      size="small"
                      className="accept-proposal-btn"
                      onClick={() => this.handleAcceptProposal(proposal)}
                    >
                      Accept
                    </Button>
                  ) : (
                    <Typography
                      className="accept-proposal-btn"
                      variant="title"
                      color="primary"
                    >
                      Accepted
                    </Typography>
                  )}

                  <Button
                    variant="contained"
                    color="primary"
                    size="small"
                    className="block-user-btn"
                    onClick={() => this.blockUser(proposal)}
                  >
                    Block
                  </Button>
                </div>
              );
            } else {
              return (
                <div className="result-card" key={proposal.id}>
                  <h3>
                    <span className="result-card-label">Mentor</span>:{' '}
                    {proposal.mentor.mentorName}
                  </h3>
                  <div>
                    <span className="result-card-label">Technology</span>:{' '}
                    {proposal.mentor.technologies}
                  </div>
                  <div>
                    <span className="result-card-label">
                      Training Start Date
                    </span>
                    : {proposal.trainingStartDate}
                  </div>
                  <div>
                    <span className="result-card-label">Training Duration</span>
                    : {proposal.duration}
                  </div>
                  <div>
                    <span className="result-card-label">Is Accepted</span>:{' '}
                    {proposal.isAcceptd ? 'Yes' : 'No'}
                  </div>
                  <div>
                    <span className="result-card-label">Training Fees:</span>{' '}
                    {proposal.mentorFees}
                  </div>
                </div>
              );
            }
          })}
      </div>
    );
  }
}
