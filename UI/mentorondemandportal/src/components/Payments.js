import React from 'react';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';

export default class Payments extends React.Component {
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
  handleMakePaymentProposal = (proposal, phase) => {
    const updatedProposal = {
      ...proposal,
      paymentStatus: {
        ...proposal.paymentStatus,
        [phase]: true
      }
    };

    fetch(`http://localhost:3001/proposals/${proposal.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        ...updatedProposal
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
  render() {
    const { role } = this.props.userProfile;
    return (
      <div className="payments-container">
        <h1>Payments</h1>
        {this.state.proposals
          .filter(proposal => {
            if (role === 'mentor') {
              return (
                proposal.mentor.mentorId === this.props.userProfile.mentorId
              );
            } else {
              return (
                proposal.user.id === this.props.userProfile.id &&
                proposal.isAcceptd
              );
            }
          })
          .map(proposal => {
            if (role === 'user') {
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
                  <Divider />
                  <h3 className="payments-title">Payments</h3>
                  <div>
                    {Object.keys(proposal.paymentStatus).map(payment => {
                      if (proposal.paymentStatus[payment]) {
                        return (
                          <Button
                            variant="contained"
                            color="secondary"
                            disabled
                            className="accept-proposal-btn payments-btn"
                          >
                            {payment} - Paid
                          </Button>
                        );
                      }
                      return (
                        <Button
                          key={payment}
                          variant="contained"
                          color="primary"
                          size="small"
                          className="accept-proposal-btn payments-btn"
                          onClick={() =>
                            this.handleMakePaymentProposal(proposal, payment)
                          }
                        >
                          {payment} - 25%
                        </Button>
                      );
                    })}
                  </div>
                </div>
              );
            }
          })}
      </div>
    );
  }
}
